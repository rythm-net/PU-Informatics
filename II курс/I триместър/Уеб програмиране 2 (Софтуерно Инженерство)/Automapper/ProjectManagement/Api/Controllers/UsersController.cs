using Api.ViewModels.Users;
using AutoMapper;
using Common.Dto;
using Common.Entities;
using Common.Mapper;
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
            MapperConfiguration config = new MapperConfiguration(config => config.AddProfile(new MapperProfile()));
            IMapper mapper = config.CreateMapper();

            ProjectManagementDbContext context = new ProjectManagementDbContext();
            List<User> items = context.Users.ToList();

            return Ok(
                new {
                success = true,
                data = mapper.Map<List<UserDto>>(items)
            });
        }

        [HttpPut]
        public IActionResult Put([FromBody]CreateVM model)
        {
            MapperConfiguration config = new MapperConfiguration(config => config.AddProfile(new MapperProfile()));
            IMapper mapper = config.CreateMapper();

            ProjectManagementDbContext context = new ProjectManagementDbContext();
            User item = new User();
            item.Username = model.Username;
            item.Password = model.Password;
            item.FirstName = model.FirstName;
            item.LastName = model.LastName;

            context.Users.Add(item);
            context.SaveChanges();

            return Ok(
                new
                {
                    success = true,
                    data = mapper.Map<UserDto>(item)
                });
        }

        [HttpPost]
        public IActionResult Post([FromBody] EditVM model)
        {
            MapperConfiguration config = new MapperConfiguration(config => config.AddProfile(new MapperProfile()));
            IMapper mapper = config.CreateMapper();

            ProjectManagementDbContext context = new ProjectManagementDbContext();

            User item = context.Users
                                   .Where(i => i.Id == model.Id)
                                   .FirstOrDefault();

            if (item == null)
                return NotFound();

            item.Username = model.Username;
            item.Password = model.Password;
            item.FirstName = model.FirstName;
            item.LastName = model.LastName;

            context.Users.Update(item);
            context.SaveChanges();

            return Ok(
                new
                {
                    success = true,
                    data = mapper.Map<UserDto>(item)
                });
        }

        [HttpDelete]
        public IActionResult Delete(int Id)
        {
            MapperConfiguration config = new MapperConfiguration(config => config.AddProfile(new MapperProfile()));
            IMapper mapper = config.CreateMapper();

            ProjectManagementDbContext context = new ProjectManagementDbContext();

            User item = context.Users
                                   .Where(i => i.Id == Id)
                                   .FirstOrDefault();

            if (item == null)
                return NotFound();

            context.Users.Remove(item);
            context.SaveChanges();

            return Ok(
                new
                {
                    success = true,
                    data = mapper.Map<UserDto>(item)
                });
        }
    }
}