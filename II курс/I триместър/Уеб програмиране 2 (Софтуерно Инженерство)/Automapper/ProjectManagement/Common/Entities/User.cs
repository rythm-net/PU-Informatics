using System;
using System.Collections.Generic;
using System.Text;

namespace Common.Entities
{
    public class User
    {
        public int Id { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public virtual List<Project> Projects { get; set; }
    }
}
