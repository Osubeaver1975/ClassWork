/***************************************************************************** 
This is a service

A service is a set of processing to facilitate the retrieval and storage
of data -typically in a persistent source (saved)

This service DOES NOT save data (becuase we don't have a database) the data
from this service is saved in an array (goes away when angular is closed)

*************************************************************************** */


import { Injectable, NgModule } from '@angular/core'; // Access Dependency Injection for Angular
import { MoviesInfo } from './moviesInfo';  // using the moviesinfo.ts INTERFACE

// @Injectable tells angular that this service may be dependancy Injected
@Injectable({
  providedIn: 'root'
})



export class MoviesService {

  // A module contains data and methods (aka functions) for processing that data

  // Source of the data for calls to retrieve the data 
  private listOfMovies : MoviesInfo[] = []  // 'MoviesInfo.ts'


  // a Constructoris a method to initialize the data -init'd in the code
  //it is executed automagically when the service is loaded
  // here we use the constructor to init our data source
  constructor() { 
    this.listOfMovies.push({title: "Godfather"                         , releaseYear: 1972, director: "Francis Ford Coppola"})
    this.listOfMovies.push({title: "Godfather II"                      , releaseYear: 1974, director: "Francis Ford Coppola"})
    this.listOfMovies.push({title: "Star Trek: The Wrath of Khan"      , releaseYear: 1982, director: "Nicholas Meyer"})
    this.listOfMovies.push({title: "Star Wars: The Empire Strikes Back", releaseYear: 1980, director: "Irvin Kershner"})
  }


  // methods other modules may use to interact with our service

  // This method will return the current data in our data source (listOfMovies
  // name parameters) : return-type-of-data-returned
  getMoviesList() : MoviesInfo[] {  //this function returns a moviesInfo array
    return this.listOfMovies;
  }
  // This method will receive a moviesinfo object and add it to our data source listOfMovies
  addMovies(newMovie : MoviesInfo) {
    console.table(newMovie)   //optional only here to verify new movie data coming in
    this.listOfMovies.push(newMovie)  //this line stores the new movie in the data source
    console.table(this.listOfMovies)    // optional- verify new movie was added to the array
  }
 
}
