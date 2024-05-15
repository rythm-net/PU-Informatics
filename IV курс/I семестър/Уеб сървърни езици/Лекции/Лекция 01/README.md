# CheatSheet

-----1st exec-----

1. create new folder
2. check if python is installed | python --version
3. create venv | python -m venv venv
4. launch venv | .\venv\Scripts\activate
5. pip install django 
5.1 pip install djangorestframework
6. create project | django-admin startproject webapp
6.1 cd webapp
6.2 django-admin startapp api
7. go to webapp settings and open settings.py | in installed apps add  'rest_framework', 'api', 'rest_framework.authtoken'
8. go to urls and add path -  #path('', include('api.urls')), as comment
9. create urls.py in folder api
10. migrate - python manage.py migrate
11. use python manage.py makemigrations when u have added a library or created/made changes to a model in the db! Then use python manage.py migrate
12. runserver | python manage.py runserver
13. createsuperuser | python manage.py createsuper
14. log into admin panel
