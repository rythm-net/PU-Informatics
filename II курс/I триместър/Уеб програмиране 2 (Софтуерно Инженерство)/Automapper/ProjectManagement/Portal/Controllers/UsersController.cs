using Common.Entities;
using Common.Repositories;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Portal.ViewModels.Users;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Portal.Controllers
{
    public class UsersController : Controller
    {
        public IActionResult Index()
        {
            if (String.IsNullOrEmpty(HttpContext.Session.GetString("loggedUserId")))
                return RedirectToAction("Login", "Home");

            ProjectManagementDbContext context = new ProjectManagementDbContext();

            IndexVM model = new IndexVM();
            model.Items = context.Users.ToList();

            return View(model);
        }

        [HttpGet]
        public IActionResult Create()
        {
            if (String.IsNullOrEmpty(HttpContext.Session.GetString("loggedUserId")))
                return RedirectToAction("Login", "Home");

            return View();
        }

        [HttpPost]
        public IActionResult Create(CreateVM model)
        {
            if (String.IsNullOrEmpty(HttpContext.Session.GetString("loggedUserId")))
                return RedirectToAction("Login", "Home");

            if (!ModelState.IsValid)
                return View(model);

            ProjectManagementDbContext context = new ProjectManagementDbContext();

            User item = new User();
            item.Username = model.Username;
            item.Password = model.Password;
            item.FirstName = model.FirstName;
            item.LastName = model.LastName;

            context.Users.Add(item);
            context.SaveChanges();

            return RedirectToAction("Index", "Users");
        }

        [HttpGet]
        public IActionResult Edit(int id)
        {
            if (String.IsNullOrEmpty(HttpContext.Session.GetString("loggedUserId")))
                return RedirectToAction("Login", "Home");

            ProjectManagementDbContext context = new ProjectManagementDbContext();
            User item = context.Users.Where(u => u.Id == id).FirstOrDefault();

            if (item == null)
                return RedirectToAction("Index", "Users");

            EditVM model = new EditVM();
            model.Id = item.Id;
            model.Username = item.Username;
            model.Password = item.Password;
            model.FirstName = item.FirstName;
            model.LastName = item.LastName;

            return View(model);
        }

        [HttpPost]
        public IActionResult Edit(EditVM model)
        {
            if (String.IsNullOrEmpty(HttpContext.Session.GetString("loggedUserId")))
                return RedirectToAction("Login", "Home");

            if (!ModelState.IsValid)
                return View(model);

            ProjectManagementDbContext context = new ProjectManagementDbContext();

            User item = new User();
            item.Id = model.Id;
            item.Username = model.Username;
            item.Password = model.Password;
            item.FirstName = model.FirstName;
            item.LastName = model.LastName;

            context.Users.Update(item);
            context.SaveChanges();

            return RedirectToAction("Index", "Users");
        }

        public IActionResult Delete(int id)
        {
            if (String.IsNullOrEmpty(HttpContext.Session.GetString("loggedUserId")))
                return RedirectToAction("Login", "Home");

            ProjectManagementDbContext context = new ProjectManagementDbContext();
            User itemForDelete = context.Users.Where(u => u.Id == id).FirstOrDefault();

            if (itemForDelete == null)
                return RedirectToAction("Index", "Users");

            context.Users.Remove(itemForDelete);
            context.SaveChanges();

            return RedirectToAction("Index", "Users");
        }
    }
}
