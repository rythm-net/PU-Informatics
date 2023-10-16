using Api.ViewModels.Shared;
using Common.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Api.ViewModels.Users
{
    public class IndexVM
    {
        public string OrderBy { get; set; }
        public string OrderDir { get; set; }

        public List<User> Items { get; set; }
        public FilterVM Filter { get; set; }
        public PagerVM Pager { get; set; }
    }
}
