using AutoMapper;
using Common.Dto;
using Common.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace Common.Mapper
{
    public class MapperProfile : Profile
    {
        public MapperProfile()
        {
            CreateMap<User, UserDto>();

            CreateMap<Project, ProjectDto>()
                .ForMember(m => m.Owner, c => c.MapFrom(s => s.Owner));
        }
    }
}
