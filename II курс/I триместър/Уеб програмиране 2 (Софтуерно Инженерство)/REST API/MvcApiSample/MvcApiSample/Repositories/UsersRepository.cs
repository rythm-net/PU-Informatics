using MvcApiSample.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MvcApiSample.Repositories
{
    public class UsersRepository
    {
        public static List<User> Items { get; set; }

        static UsersRepository()
        {
            Items = new List<User>();
        }
    }
}
