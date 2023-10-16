using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Portal.ViewModels.Home
{
    public class LoginVM
    {
        [DisplayName("Username")]
        [Required(ErrorMessage = "This field is Required")]
        public string Username { get; set; }

        [DisplayName("Password")]
        [Required(ErrorMessage = "This field is Required")]
        public string Password { get; set; }
    }
}
