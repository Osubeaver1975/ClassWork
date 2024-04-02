// this is executed as part of the bootstrap process
//
// Think of it as starting the Angular App
//
// import gives us access to previously written code we need
//

import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';

// this starts the bootstrap process using the 
// app component
// and 
// app config code
bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
