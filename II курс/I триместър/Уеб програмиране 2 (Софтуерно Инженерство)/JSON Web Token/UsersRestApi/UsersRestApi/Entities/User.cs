using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace UsersRestApi.Entities
{
    public class User
    {
        public int Id { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
    }
}
