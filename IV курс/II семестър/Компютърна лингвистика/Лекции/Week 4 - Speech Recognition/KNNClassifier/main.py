import nltk
from nltk.corpus import genesis
from nltk.corpus import wordnet as wn
import numpy as np
import pandas as pd
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords

nltk.download('genesis')
nltk.download('wordnet')
nltk.download('punkt')
nltk.download('averaged_perceptron_tagger')
genesis_ic = wn.ic(genesis, False, 0.0)


class KNN_NLC_Classifer():
    def __init__(self, k=1, distance_type='path'):
        self.k = k
        self.distance_type = distance_type

    # This function is used for training
    def fit(self, x_train, y_train):
        self.x_train = x_train
        self.y_train = y_train

    # This function runs the K(1) nearest neighbour algorithm and
    # returns the label with closest match.
    def predict(self, x_test):
        self.x_test = x_test
        y_predict = []

        for i in range(len(x_test)):
            max_sim = 0
            max_index = 0
            for j in range(self.x_train.shape[0]):
                temp = self.document_similarity(x_test[i], self.x_train[j])
                if temp > max_sim:
                    max_sim = temp
                    max_index = j
            y_predict.append(self.y_train[max_index])
        return y_predict

    def convert_tag(self, tag):
        """Convert the tag given by nltk.pos_tag to the tag used by wordnet.synsets"""
        tag_dict = {'N': 'n', 'J': 'a', 'R': 'r', 'V': 'v'}
        try:
            return tag_dict[tag[0]]
        except KeyError:
            return None

    def doc_to_synsets(self, doc):
        """
            Returns a list of synsets in document.
            Tokenizes and tags the words in the document doc.
            Then finds the first synset for each word/tag combination.
        If a synset is not found for that combination it is skipped.

        Args:
            doc: string to be converted

        Returns:
            list of synsets
        """
        tokens = word_tokenize(doc + ' ')

        l = []
        tags = nltk.pos_tag([tokens[0] + ' ']) if len(tokens) == 1 else nltk.pos_tag(tokens)

        for token, tag in zip(tokens, tags):
            syntag = self.convert_tag(tag[1])
            syns = wn.synsets(token, syntag)
            if (len(syns) > 0):
                l.append(syns[0])
        return l

    def similarity_score(self, s1, s2, distance_type='path'):
        """
        Calculate the normalized similarity score of s1 onto s2
        For each synset in s1, finds the synset in s2 with the largest similarity value.
        Sum of all of the largest similarity values and normalize this value by dividing it by the
        number of largest similarity values found.

        Args:
            s1, s2: list of synsets from doc_to_synsets

        Returns:
            normalized similarity score of s1 onto s2
        """
        s1_largest_scores = []

        for i, s1_synset in enumerate(s1, 0):
            max_score = 0
            for s2_synset in s2:
                if distance_type == 'path':
                    score = s1_synset.path_similarity(s2_synset, simulate_root=False)
                else:
                    score = s1_synset.wup_similarity(s2_synset)
                if score != None:
                    if score > max_score:
                        max_score = score

            if max_score != 0:
                s1_largest_scores.append(max_score)

        mean_score = np.mean(s1_largest_scores)

        return mean_score

    def document_similarity(self, doc1, doc2):
        """Finds the symmetrical similarity between doc1 and doc2"""

        synsets1 = self.doc_to_synsets(doc1)
        synsets2 = self.doc_to_synsets(doc2)

        return (self.similarity_score(synsets1, synsets2) + self.similarity_score(synsets2, synsets1)) / 2


FILENAME = 'primeri.csv'

dataset = pd.read_csv(FILENAME, header=None)
dataset.rename(columns={0: 'text', 1: 'answer'})
print(dataset)
dataset['output'] = np.where(dataset[0] == 'temperature', 1, 0)
Num_Words = dataset.shape[0]
print("Examples: \n", dataset)

import re

nltk.download('stopwords')
s = stopwords.words('english')
s.extend(['today', 'tomorrow', 'outside', 'out', 'there', 'much', 'many', 'going'])
ps = nltk.wordnet.WordNetLemmatizer()
for i in range(dataset.shape[0]):
    review = re.sub('[^a-zA-Z]', ' ', dataset.loc[i, 0])
    review = review.lower()
    review = review.split()
    review = [ps.lemmatize(word) for word in review if not word in s]
    review = ' '.join(review)
    dataset.loc[i, 0] = review
    if dataset.loc[i, 1] == 'temperature':
        dataset.loc[i, 'output'] = 1


print("Dataset after lemmatization: ")
print(dataset)

X_train = dataset[0]
Y_train = dataset['output']

classifier = KNN_NLC_Classifer(k=1, distance_type='path')
classifier.fit(X_train, Y_train)

while True:
    user_input = input()
    review = re.sub('[^a-zA-Z]', ' ', user_input)
    review = review.lower()
    review = review.split()
    review = [ps.lemmatize(word) for word in review if not word in s]
    review = ' '.join(review)
    test_corpus = [review]
    y_pred_final = classifier.predict(test_corpus)
    output_df = pd.DataFrame(data={'text': [user_input], 'code': y_pred_final, 'lemmatized': [review]})
    output_df['answer'] = np.where(output_df['code'] == 1, 'Temperature', 'Conditions')

    print("Prediction: ")
    print(output_df)





