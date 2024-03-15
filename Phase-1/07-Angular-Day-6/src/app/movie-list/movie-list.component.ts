import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MoviesInfo } from '../moviesInfo'; // access the MoviesList INTERFACE (moviesInfo.ts)
import { MoviesService } from '../movies.service';  // access code for MovieServices movies.service.ts
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './movie-list.component.html',
  styleUrl: './movie-list.component.css'
})
export class MovieListComponent {

  // This will hold the data for the movies to be displayed
  // the data will come from a call to a service
  //    var-name  : data-type (MoviesInfo (moviesinfo.ts) is an object in a particular form)
public moviesList : MoviesInfo [] ; //This is an array of MoviesInfo objects like strings or
                                    // or numbers. This is movie name, director, year as the data-type


                                    //Constructor is used to init the data in the component
                                    //
                                    // This style of constructor will define the variable, create a  
                                    //              moviesService movies.service.ts
                                    //              using Dependency Injection
                                    // Dependency Injection is the automatic creation of variables and objects required
                                    //  
                                    // Dependeuples the service from the code
                                    //  (makes it a lot easier to change the serveice)
                                    // without Dependency Injection the code would look like this:
                                    //        private movieService; 
                                    //
                                    //        constructor() {
                                    //                        movieService = new MoviesServices();  // create a service
                                    //   }                                                     // and assign it to the variable
                                    
constructor(private movieService  : MoviesService ) {
  // Call the service method to send back the current list of movies from the data source
  this.moviesList = movieService.getMoviesList(); // 
}
// 1. movieService.getMoviesList()  - go to the movieSeervice and run the method 'getMoviesList'
//  2. = - take with the method returns and assign it to 
//  3. this.moviesList is assigned the data from step 2
}
