from rest_framework.response import Response
from rest_framework.decorators import api_view
from base.models import Author, Book
from .serializer import AuthorSerializer, BookSerializer
from rest_framework import status

@api_view(['GET'])
def getAuthors(request):
    items = Author.objects.all()
    serializer = AuthorSerializer(items, many=True)
    return Response(serializer.data)

@api_view(['GET'])
def getAuthor(request, pk):
    try: 
        author = Author.objects.get(pk=pk) 
    except Author.DoesNotExist: 
        return Response('The author does not exist', status=status.HTTP_404_NOT_FOUND) 
 
    serializer = AuthorSerializer(author)
    return Response(serializer.data)

@api_view(['GET'])
def getBooks(request):
    items = Book.objects.all()
    serializer = BookSerializer(items, many=True)
    return Response(serializer.data)

@api_view(['GET'])
def getBook(request, pk):
    try: 
        book = Book.objects.get(pk=pk) 
    except Book.DoesNotExist: 
        return Response('The book does not exist', status=status.HTTP_404_NOT_FOUND) 
 
    serializer = BookSerializer(book)
    return Response(serializer.data)

@api_view(['POST'])
def addBook(request):
    serializer = BookSerializer(data=request.data)
    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)
