using Common.Entities;
using Common.Repositories;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        [HttpGet]
        public IActionResult Get()
        {
            ProjectManagementDbContext context = new ProjectManagementDbContext();
            List<User> items = context.Users.ToList();

            return Ok(
                new {
                success = true,
                data = items
            });
        }
    }
}
