using System;
using System.Collections.Generic;
using System.Text;

namespace Common.Dto
{
    public class ProjectDto
    {
        public int Id { get; set; }
        public int OwnerId { get; set; }

        public string Title { get; set; }
        public string Description { get; set; }

        public UserDto Owner { get; set; }
    }
}
