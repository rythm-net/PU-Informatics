using Api.ViewModels.Projects;
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
    public class ProjectsController : ControllerBase
    {
        [HttpGet]
        public IActionResult Get()
        {
            MapperConfiguration config = new MapperConfiguration(config => config.AddProfile(new MapperProfile()));
            IMapper mapper = config.CreateMapper();

            ProjectManagementDbContext context = new ProjectManagementDbContext();
            List<Project> items = context.Projects.ToList();

            return Ok(
                new
                {
                    success = true,
                    data = mapper.Map<List<ProjectDto>>(items)
                });
        }

        [HttpPut]
        public IActionResult Put([FromBody] CreateVM model)
        {
            MapperConfiguration config = new MapperConfiguration(config => config.AddProfile(new MapperProfile()));
            IMapper mapper = config.CreateMapper();

            ProjectManagementDbContext context = new ProjectManagementDbContext();
            Project item = new Project();
            item.OwnerId = model.OwnerId;
            item.Title = model.Title;
            item.Description = model.Description;

            context.Projects.Add(item);
            context.SaveChanges();

            return Ok(
                new
                {
                    success = true,
                    data = mapper.Map<ProjectDto>(item)
                });
        }

        [HttpPost]
        public IActionResult Post([FromBody] EditVM model)
        {
            MapperConfiguration config = new MapperConfiguration(config => config.AddProfile(new MapperProfile()));
            IMapper mapper = config.CreateMapper();

            ProjectManagementDbContext context = new ProjectManagementDbContext();

            Project item = context.Projects
                                   .Where(i => i.Id == model.Id)
                                   .FirstOrDefault();

            if (item == null)
                return NotFound();

            item.OwnerId = model.OwnerId;
            item.Title = model.Title;
            item.Description = model.Description;

            context.Projects.Update(item);
            context.SaveChanges();

            return Ok(
                new
                {
                    success = true,
                    data = mapper.Map<ProjectDto>(item)
                });
        }

        [HttpDelete]
        public IActionResult Delete(int Id)
        {
            MapperConfiguration config = new MapperConfiguration(config => config.AddProfile(new MapperProfile()));
            IMapper mapper = config.CreateMapper();

            ProjectManagementDbContext context = new ProjectManagementDbContext();

            Project item = context.Projects
                                   .Where(i => i.Id == Id)
                                   .FirstOrDefault();

            if (item == null)
                return NotFound();

            context.Projects.Remove(item);
            context.SaveChanges();

            return Ok(
                new
                {
                    success = true,
                    data = mapper.Map<ProjectDto>(item)
                });
        }
    }
}
