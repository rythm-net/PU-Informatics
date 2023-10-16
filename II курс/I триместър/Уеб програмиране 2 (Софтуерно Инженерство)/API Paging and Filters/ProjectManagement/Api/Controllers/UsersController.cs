using Api.ViewModels.Shared;
using Api.ViewModels.Users;
using Common.Entities;
using Common.Repositories;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Threading.Tasks;

namespace Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        [HttpGet]
        public IActionResult Get([FromBody]IndexVM model)
        {
            model.Pager ??= new PagerVM();
            model.Pager.Page = model.Pager.Page <= 0
                                    ? 1
                                    : model.Pager.Page;

            model.Pager.ItemsPerPage = model.Pager.ItemsPerPage <= 0
                                        ? 10
                                        : model.Pager.ItemsPerPage;

            model.Filter ??= new FilterVM();
            model.OrderBy = (model.OrderBy != "Username") &&
                            (model.OrderBy != "FirstName") &&
                            (model.OrderBy != "LastName")
                            ? "Id"
                            : model.OrderBy;

            model.OrderDir = model.OrderDir != "Desc"
                                ? "Asc"
                                : model.OrderDir;

            Expression<Func<User, bool>> filter = u =>
                        (string.IsNullOrEmpty(model.Filter.Username) || u.Username.Contains(model.Filter.Username)) &&
                        (string.IsNullOrEmpty(model.Filter.FirstName) || u.FirstName.Contains(model.Filter.FirstName)) &&
                        (string.IsNullOrEmpty(model.Filter.LastName) || u.LastName.Contains(model.Filter.LastName));

            ProjectManagementDbContext context = new ProjectManagementDbContext();
            model.Pager.PagesCount = (int)Math.Ceiling(context.Users.Count() / (double)model.Pager.ItemsPerPage);
            IQueryable<User> query = context.Users
                                        .Where(filter)
                                        .Skip(model.Pager.ItemsPerPage * (model.Pager.Page - 1))
                                        .Take(model.Pager.ItemsPerPage);

            var orderByMember = typeof(User).GetProperty(model.OrderBy);
            var param = Expression.Parameter(typeof(User), "u");
            if (!orderByMember.PropertyType.IsValueType)
            {
                var order = Expression.Lambda<Func<User, object>>(
                                Expression.Property(param, model.OrderBy),
                                param
                            );

                if (model.OrderDir == "Desc")
                    query = query.OrderByDescending(order);
                else
                    query = query.OrderBy(order);
            }
            else if (orderByMember.PropertyType.IsAssignableFrom(typeof(int)))
            {
                var order = Expression.Lambda<Func<User, int>>(
                                Expression.Property(param, model.OrderBy),
                                param
                            );

                if (model.OrderDir == "Desc")
                    query = query.OrderByDescending(order);
                else
                    query = query.OrderBy(order);
            }

            model.Items = query.ToList();

            return Ok(
                new {
                success = true,
                data = model
            });
        }
    }
}
