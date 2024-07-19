import requests

url = "https://api.meaningcloud.com/topics-2.0"

payload = {
    'key': 'ba0ec47c838e384fbc3642db021edd6e',
    'txt': 'YOUR TEXT HERE',
    'lang': 'en',  # 2-letter code, like en es fr ...
    'tt': 'a'  # all topics
}

lines = ''
with open('readme.txt', encoding='utf-8') as f:
    payload['txt'] = f.readlines()
    lines = payload['txt']

response = requests.post(url, data=payload)

print('Status code:', response.status_code)

for concepts in response.json()['concept_list'] + response.json()['entity_list']:
    print(f"Base form: {concepts['form']}, Type: {concepts['sementity']['type']}, Relevance: {concepts['relevance']}")

countries = [country
             for country in response.json()['entity_list']
             if "GeoPoliticalEntity>Country" in country['sementity']['type']]

for c in countries:
    print(f"Country: {c['form']}")

print(f"Number of entities: {len(response.json()['entity_list'])}")
print(f"Number of countries: {len(countries)} ")
print(f"Number of concepts: {len(response.json()['concept_list'])}")

url = "https://api.meaningcloud.com/summarization-1.0"

payload = {
    'key': 'ba0ec47c838e384fbc3642db021edd6e',
    'txt': lines,
    'sentences': '6'
}

response = requests.post(url, data=payload)

print(f"Summary of text: {response.json()['summary']}")


