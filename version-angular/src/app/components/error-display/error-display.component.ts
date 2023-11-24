import { Component, Input, OnInit } from "@angular/core";
import { AbstractControl } from "@angular/forms";

@Component({
    selector: 'app-error-display',
    templateUrl: './error-display.component.html',
    styleUrls: ['./error-display.component.css']
  })
  export class ErrorDisplayComponent implements OnInit {

    constructor() {
       
    }
    
    ngOnInit(): void {
        
    }

    @Input() control!: AbstractControl;


  }