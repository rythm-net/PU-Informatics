using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Api.ViewModels.Projects
{
    public class CreateVM
    {
        public int OwnerId { get; set; }

        public string Title { get; set; }
        public string Description { get; set; }
    }
}
