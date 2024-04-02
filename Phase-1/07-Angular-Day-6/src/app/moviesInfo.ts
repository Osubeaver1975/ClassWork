/*********************************************************************** 
 This is an INTERFACE
 
 An interface is a user-defined data type
 it describes a format of data that may be used in multiple places
 Allows sharing of data format between components, service, etc

 Suppose: the same object layout is required in 20 different places
        you could code it in each of the 20 places. OR --> used an 
        interface and call the interface *
        * think about changes you may need to make ---> one change to the
        format, would requre changing 20/ dozens, thousands of changes!
********************************************************************* */

// This interface describes a "MoviesInfo" object
// we export it so others can use it too
export interface MoviesInfo {
    title       : string        ;
    releaseYear : number        ;
    director    : string        ;
}