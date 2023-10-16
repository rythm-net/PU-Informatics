using Microsoft.AspNetCore.Mvc;
using MvcApiSample.ViewModels.Home;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MvcApiSample.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            //ViewData["someData"] = "This is some data from the Action";

            //ViewResult res = new ViewResult();
            //res.ViewName = "/Views/Whatever/Iwassowhatever.cshtml";
            //res.ViewData = this.ViewData;

            //ViewResult res = this.View();

            IndexVM model = new IndexVM();
            model.Title = "Index page";
            model.Content = "This is some content";

            JsonResult res = new JsonResult(model);
            return res;
        }
    }
}
