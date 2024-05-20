from django.contrib import admin
from .models import Todo, Role, TeamMember

# Register your models here.
@admin.register(Todo)
class TodoAdmin(admin.ModelAdmin):
    pass

@admin.register(Role)
class RoleAdmin(admin.ModelAdmin):
    pass

@admin.register(TeamMember)
class TeamMemberAdmin(admin.ModelAdmin):
    pass