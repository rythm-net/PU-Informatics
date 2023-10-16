using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using UsersRestApi.Entities;
using UsersRestApi.Repositories;

namespace UsersRestApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TokenController : ControllerBase
    {
        [HttpPut]
        public IActionResult Put(string username, string password)
        {
            User loggedUser = UsersRepository.Items.Find(u => u.Username == username &&
                                                              u.Password == password);
            if (loggedUser == null)
                return Unauthorized();

            var claims = new[]
            {
                new Claim("LoggedUserId", loggedUser.Id.ToString())
            };

            var key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes("!Password123!Password123"));
            var signingCredentials = new SigningCredentials(key, SecurityAlgorithms.HmacSha256);

            var token = new JwtSecurityToken(
                "ulpia.tech",
                "projectmanagement.angular.app",
                claims,
                expires: DateTime.UtcNow.AddMinutes(10),
                signingCredentials: signingCredentials
            );

            JwtSecurityTokenHandler tokenHandler = new JwtSecurityTokenHandler();
            string jwt = tokenHandler.WriteToken(token);

            return Ok(new { success = true, token = jwt });
        }
    }
}
