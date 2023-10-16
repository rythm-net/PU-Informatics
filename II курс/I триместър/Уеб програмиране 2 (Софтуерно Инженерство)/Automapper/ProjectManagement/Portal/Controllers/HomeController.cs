using Common.Entities;
using Common.Repositories;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Portal.ViewModels.Home;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Portal.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Login(LoginVM model)
        {
            if (!ModelState.IsValid)
                return View(model);

            ProjectManagementDbContext context = new ProjectManagementDbContext();
            User loggedUser = context.Users.Where(u => u.Username == model.Username &&
                                                    u.Password == model.Password)
                                           .FirstOrDefault();

            if (loggedUser == null)
            {
                ModelState.AddModelError("authError", "Could not find such user");
                return View(model);
            }

            HttpContext.Session.SetString("loggedUserId", loggedUser.Id.ToString());

            return RedirectToAction("Index", "Home");
        }

        public IActionResult Logout()
        {
            HttpContext.Session.Remove("loggedUserId");

            return RedirectToAction("Index", "Home");
        }
    }
}
