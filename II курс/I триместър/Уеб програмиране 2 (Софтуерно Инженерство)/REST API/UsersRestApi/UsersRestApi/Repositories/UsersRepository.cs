using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UsersRestApi.Entities;

namespace UsersRestApi.Repositories
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
