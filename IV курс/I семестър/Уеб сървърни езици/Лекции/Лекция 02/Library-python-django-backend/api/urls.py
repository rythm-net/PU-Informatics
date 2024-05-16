from django.urls import path, re_path
from . import views

urlpatterns = [ 
    re_path(r'^api/author$', views.getAuthors),
    re_path(r'^api/author/(?P<pk>[0-9]+)$', views.getAuthor),
    re_path(r'^api/book$', views.getBooks),
    re_path(r'^api/book/(?P<pk>[0-9]+)$', views.getBook),
]