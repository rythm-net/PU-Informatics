using Common.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace Common.Repositories
{
    public class ProjectManagementDbContext : DbContext
    {
        public DbSet<User> Users { get; set; }

        public ProjectManagementDbContext()
        {
        }

        public ProjectManagementDbContext(DbContextOptions<ProjectManagementDbContext> options) : base(options)
        {
            
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder
                    .UseSqlServer("Server=localhost;Database=ProjectManagementDB;User Id=nikiv;Password=nikipass;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>().HasData(new User()
            {
                Id = 1,
                Username = "nikiv",
                Password = "nikipass",
                FirstName = "Nikola",
                LastName = "Valchanov"
            });
        }
    }
}
