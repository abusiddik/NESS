<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html lang="en" ng-app="myApp">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="ico/favicon.png">

        <title>Election Commission</title>
         <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>  
        <link rel="stylesheet" href="webjars/bootstrap-material-design/0.3.0/css/material.min.css"/>  
        <link rel="stylesheet" href="webjars/bootstrap-material-design/0.3.0/css/ripples.min.css"/> 
        <link rel="stylesheet" href="webjars/bootstrap-material-design/0.3.0/css/roboto.min.css"/> 
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/main.css" />
    
    </head>

    <body ng-controller="MainController">
        <!-- Fixed navbar -->
      
            <div class="container-fluid">
                 
                        <section id="topSide">
            <div class="col-md-3">
                <p style="margin-top: 9.5px;"><msg key="appName"></msg></p>
            </div>
            <div class="pull-right">
                <div class="row">
                    <div class="col-md-12">
                        <div class="btn-group btn-group-sm">
                            <a class="btn btn-default"
                               ng-class="(language() == 'bn') ? 'btn-primary' : ''"
                               ng-click="setLanguage('bn')"><msg key="lang"></msg></a> <a
                               class="btn btn-default"
                               ng-class="(language() == 'en') ? 'btn-primary' : ''"
                               ng-click="setLanguage('en')">English</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="topSec">
            <div class="container-fluid">
              <div class="col-md-3">
                  <a href="/ness">
                       <img src="img/logo_bn.png" alt="" />
                  </a>
              </div>
                
                
                
            </div>
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
             
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span>58</span>Ministry <span class="line">|</span></a></li>
                <li><a href="#"><span>353</span> Department & others<span class="line">|</span></a></li>
                <li><a href="#"><span>8</span> County<span class="line">|</span></a></li>
                <li><a href="#"><span>64</span>District<span class="line">|</span></a></li>
                <li><a href="#"><span>491</span> Upazila<span class="line">|</span></a></li>
                <li><a href="#"><span>491</span> Union</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
      
        </section>

                    <!--       ***************** Top Section Ends Here  *****************-->
        <nav class="navbar navbar-default" id="mainNav">
          <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/ness">HOME</a>
        </div>
        
        <div class="collapse navbar-collapse js-navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="dropdown mega-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">About Bangladesh <span class="caret"></span></a>        
              <ul class="dropdown-menu mega-dropdown-menu">
                <li class="col-sm-3">
                  <ul>
                    <li><a href="#">Prime Minnister Office</a></li>
                    <li><a href="#">National Parliament</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Ministry Of Parliament</a></li>                            
                    <li><a href="#">Law Ministry</a></li>
                  </ul>
                </li>
                <li class="col-sm-3">
                  <ul>
                    <li><a href="#">Others Office</a></li>
                    <li><a href="#">Statistics Of Bangladesh</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Tourism Of Bangladesg</a></li>
                    <li><a href="#">National Budget</a></li>                         
                  </ul>
                </li>
              </ul>       
            </li>
            <li><a href="#/party">E-Services</a></li>
            <li><a href="#">Service Sectors</a></li>
            <li class="dropdown mega-dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Buisness<span class="caret"></span></a>        
              <ul class="dropdown-menu mega-dropdown-menu">
                <li class="col-sm-3">
                    <ul>
                    <li><a href="#">New Sponsors</a></li>
                    <li><a href="#">Trade license</a></li>
                    <li class="divider"></li>
                    <li><a href="">Trading Corporation Of Bangladesh</a></li>
                  </ul>
                </li>
                <li class="col-sm-3">
                  <ul>
                    <li><a href="#">New Buisness</a></li>
                    <li><a href="#">Open Bank Account</a></li>
                    <li><a href="#">Share MArket</a></li>
                  </ul>
                </li>
              </ul>       
            </li>
            <li><a href="#">Achivement</a></li>
            <li><a href="#/adminlogin">Login</a></li>
            <li><a href="#">Services Center</a></li>
              <li><a href="#/admin">Admin Panel</a></li>
          </ul>
        </div><!-- /.nav-collapse -->
        </nav>
                
                
                
                <!--/.nav-collapse -->
            </div>

        <div class="container-fluid page">
 
            
            
            
            <ng-view></ng-view>
        </div>
        <footer>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                         <div class="footer" id="footer">
                  <div class="container-fluid">
                      <div class="row">
                          <div class="col-lg-3  col-md-3 col-sm-4 col-xs-6">
                              <h3> Contact Information </h3>
                              <ul>
                                  <li>
                                    <i class="fa fa-map-marker"></i>
                                        &nbsp 101/Abc Main Tower, Main Road,
                                    <br/>&nbsp&nbsp&nbsp&nbsp
                                    Dhaka, Bangladesh.
                                  </li>
                                  <li>
                                    <i class="fa fa-phone"></i>
                                    &nbsp&nbspPhone : +880 1111 - 222 - 333
                                  </li>
                                  <li> 
                                    <a href="mailto:someone@example.com">
                                      <i class="fa fa-envelope"></i> &nbsp Email Us
                                    </a> 
                                  </li>
                              </ul>
                          </div>
                          <div class="col-lg-3  col-md-3 col-sm-4 col-xs-6">
                              <h3> Useful Links </h3>
                              <ul>
                                  <li> <a href="http://www.mofa.gov.bd/%5Bfield_web_address%5D"> Prime Minister's Office</a> </li>
                                  <li> 
                                    <a href="http://www.btrc.gov.bd/useful-links/ministry-public-administrator">
                                      Ministry of Public Administrator 
                                    </a>
                                  </li>
                                  <li> <a href="http://www.cabinet.gov.bd/index.php?lang=bn"> Cabinet Division</a> </li>
                                  <li> <a href="http://www.bangladesh.gov.bd"> National Web Portal </a> </li>
                              </ul>
                          </div>
                          <div class="col-lg-3  col-md-3 col-sm-4 col-xs-6 latest-news">
                              <h3> Latest News </h3>
                              <ul>
                                  <li>
                                    <a href="#">
                                      facebook crack the movie advertisment code:what it means for you. 
                                      <span>August 3,2015</span>
                                    </a>
                                  </li>
                                <li>
                                    <a href="#">
                                      facebook crack the movie advertisment code:what it means for you .
                                      <span>August 3,2015</span>
                                    </a>
                                  </li>
                                <li>
                                    <a href="#">
                                      facebook crack the movie advertisment code:what it means for you.
                                      <span>August 3,2015</span>
                                    </a>
                                  </li>
                              </ul>
                          </div>
                          <div class="col-lg-3  col-md-3 col-sm-6 col-xs-12 ">
                              <h3> Newsletter </h3>
                              <p class="newsltr">To Get Update ALl Latest Thing Please Subscribe</p>
                              <div class="input-group">
                                <input type="text" class="form-control" placeholder="Subscribe for...">
                                <span class="input-group-btn">
                                  <button class="btn btn-default" type="button">
                                      <span class="glyphicon glyphicon-envelope"></span>
                                    </button>
                                </span>
                              </div>
                              <ul class="social">
                                  <li> <a href="#"> <i class=" fa fa-facebook">   </i> </a> </li>
                                  <li> <a href="#"> <i class="fa fa-twitter">   </i> </a> </li>
                                  <li> <a href="#"> <i class="fa fa-google-plus">   </i> </a> </li>
                                  <li> <a href="#"> <i class="fa fa-pinterest">   </i> </a> </li>
                                  <li> <a href="#"> <i class="fa fa-youtube">   </i> </a> </li>
                              </ul>
                          </div>
                      </div>
                      <!--/.row--> 
                  </div>
                  <!--/.container-fluid--> 
              </div>
              <!--/.footer-->
              
              <div class="footer-bottom">
                  <div class="container-fluid">
                      <p class="pull-left"> Copyright © 2017 All right reserved. </p>
                  </div>
              </div>
                    </div>
                </div>
            </div>
        </footer>

        <script type="text/javascript" src="webjars/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.3.14/angular.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.3.14/angular-route.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.3.14/angular-resource.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.3.14/angular-cookies.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.3.14/angular-messages.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.3.14/angular-animate.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.3.14/angular-aria.min.js"></script>
        <script type="text/javascript" src="webjars/angularjs/1.3.14/angular-touch.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="webjars/angular-ui-bootstrap/0.12.1-1/ui-bootstrap-tpls.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap-material-design/0.3.0/js/material.min.js"></script>  
        <script type="text/javascript" src="webjars/bootstrap-material-design/0.3.0/js/ripples.min.js"></script> 
        <script type="text/javascript" src="js/angular-bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.i18n.properties-min-1.0.9.js"></script>
        <script type="text/javascript" src="js/controller.js"></script>
        <script type="text/javascript" src="js/filter.js"></script>
        <script type="text/javascript" src="js/i18n.js"></script>
        <script type="text/javascript" src="js/base64.js"></script>
        <script type="text/javascript" src="js/init.js"></script>
        <script src="js/angular.min.js" type="text/javascript"></script>
        <script src="js/angular-resource.min.js" type="text/javascript"></script>
 
                                          

    </body>

</html>

