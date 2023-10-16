using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MvcExplained.Controllers
{
    public class HomeController
    {
        public string Index()
        {
            return "Hello World";
        }

        public string One()
        {
            return "You just executed /Home/One";
        }

        public string Two()
        {
            return "You just executed /Home/Two";
        }
    }
}
