import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root', // this is where to insert our template code
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html', // says this is the html we want
  styleUrl: './app.component.css' // says use this CSS for global styling
})
export class AppComponent {
  title = '08-Angular-Day-2';
}
