#pragma checksum "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "cf8895d0976ce5cb645e8b4b489ab08886dacebb"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Home_Login), @"mvc.1.0.view", @"/Views/Home/Login.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"cf8895d0976ce5cb645e8b4b489ab08886dacebb", @"/Views/Home/Login.cshtml")]
    public class Views_Home_Login : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<Portal.ViewModels.Home.LoginVM>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml"
   
    Layout = "/Views/Shared/_Site.cshtml";
    ViewData["Title"] = "LOGIN";

#line default
#line hidden
#nullable disable
            WriteLiteral("<form action=\"/Home/Login\" method=\"post\">\r\n    <table>\r\n        <tr>\r\n            <td>");
#nullable restore
#line 9 "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml"
           Write(Html.LabelFor(m => m.Username));

#line default
#line hidden
#nullable disable
            WriteLiteral(":</td>\r\n            <td>");
#nullable restore
#line 10 "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml"
           Write(Html.TextBoxFor(m => m.Username));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n            <td>");
#nullable restore
#line 11 "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml"
           Write(Html.ValidationMessageFor(m => m.Username));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n        </tr>\r\n        <tr>\r\n            <td>");
#nullable restore
#line 14 "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml"
           Write(Html.LabelFor(m => m.Password));

#line default
#line hidden
#nullable disable
            WriteLiteral(":</td>\r\n            <td>");
#nullable restore
#line 15 "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml"
           Write(Html.PasswordFor(m => m.Password));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n            <td>");
#nullable restore
#line 16 "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml"
           Write(Html.ValidationMessageFor(m => m.Password));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n        </tr>\r\n        <tr>\r\n            <td></td>\r\n            <td>");
#nullable restore
#line 20 "D:\onedrive\2022-asp-net-core-training\other\automapper\ProjectManagement\Portal\Views\Home\Login.cshtml"
           Write(Html.ValidationMessage("authError"));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\r\n            <td></td>\r\n        </tr>\r\n        <tr>\r\n            <td></td>\r\n            <td><input style=\"float:right\" type=\"submit\" value=\"Login\" /></td>\r\n            <td></td>\r\n        </tr>\r\n    </table>\r\n</form>");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<Portal.ViewModels.Home.LoginVM> Html { get; private set; }
    }
}
#pragma warning restore 1591
