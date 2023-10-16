using Microsoft.AspNetCore.Mvc;
using MvcApiSample.Entities;
using MvcApiSample.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MvcApiSample.Controllers
{
    public class UsersController : Controller
    {
        [HttpGet]
        public IActionResult Index()
        {
            return Json(UsersRepository.Items);
        }

        [HttpGet]
        public IActionResult GetById(int id)
        {
            return View();
        }

        [HttpPut]
        public IActionResult Create([FromBody]User model)
        {
            int id = 1;
            foreach(User item in UsersRepository.Items)
            {
                if (id <= item.Id)
                    id = item.Id + 1;
            }

            model.Id = id;
            UsersRepository.Items.Add(model);

            return Created(model.Id.ToString(), model);
        }

        [HttpDelete]
        public IActionResult Delete(int id)
        {
            User user = null;
            foreach (User item in UsersRepository.Items)
            {
                if (id == item.Id)
                {
                    user = item;
                    break;
                }
            }

            if (user != null)
            {
                UsersRepository.Items.Remove(user);
                return Ok(user);
            }

            return NotFound(user);
        }
    }
}
