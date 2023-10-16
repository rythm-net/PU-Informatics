using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UsersRestApi.Entities;
using UsersRestApi.Repositories;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace UsersRestApi.Controllers
{
    [Authorize(AuthenticationSchemes = JwtBearerDefaults.AuthenticationScheme)]
    [Route("api/[controller]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        [HttpGet]
        public IActionResult Get()
        {
            return Ok(UsersRepository.Items);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            User item = UsersRepository.Items.Find(u => u.Id == id);

            if (item == null)
                return NotFound();

            return Ok(item);
        }

        [HttpPost]
        public void Post([FromBody] string value)
        {

        }

        [HttpPut]
        public IActionResult Put([FromBody] User model)
        {
            int id = 1;
            foreach (User item in UsersRepository.Items)
            {
                if (id <= item.Id)
                    id = item.Id + 1;
            }

            model.Id = id;
            UsersRepository.Items.Add(model);

            return Created(model.Id.ToString(), model);
        }

        [HttpDelete("{test}")]
        public IActionResult Delete(int test)
        {
            User user = null;
            foreach (User item in UsersRepository.Items)
            {
                if (test == item.Id)
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
