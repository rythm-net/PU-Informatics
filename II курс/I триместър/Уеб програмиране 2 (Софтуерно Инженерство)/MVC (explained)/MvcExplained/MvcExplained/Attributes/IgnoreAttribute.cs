using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MvcExplained.Attributes
{
    public class IgnoreAttribute : Attribute
    {
        public string ErrorMessage { get; set; }
    }
}
