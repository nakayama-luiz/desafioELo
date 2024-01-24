import { Input, OnInit } from '@angular/core';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  campo1: string = '';
  @Input() campo2: string = '';
  @Input() campo3: string = '';




  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  onCampo1Change() {
    this.campo2 = 'poggers'
    this.campo3 = 'noggers'

  }



}
