using MvcExplained.Attributes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MvcExplained.Controllers
{
    public class UsersController
    {
        [Ignore(ErrorMessage = "WAT!?")]
        public string Index()
        {
            return "This method should list all users";
        }

        [Ignore(ErrorMessage = "You can't execute the EDIT action!")]
        public string Edit()
        {
            return "Editing user";
        }

        public string Delete()
        {
            return "Deleting user";
        }
    }
}
