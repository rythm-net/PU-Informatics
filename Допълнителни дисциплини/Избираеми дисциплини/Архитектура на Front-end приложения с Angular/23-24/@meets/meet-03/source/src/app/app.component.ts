import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { ListViewComponent } from './list-view/list-view.component';

@Component({
  selector    : 'app-root',
  standalone  : true,
  imports     : [
    RouterOutlet,
    FormsModule,
    CommonModule,
    ListViewComponent
  ],
  templateUrl : './app.component.html',
  styleUrl    : './app.component.css'
})
export class AppComponent {

  public index = 0;

  public tempTitle;
  public tempNote;

  public modelSize = 15;

  // опааа ти си низз
  public modelTitle = '';
  public modelNote = '';

  public videoLinkCollection = [
    {
      link: 'https://www.youtube.com/watch?v=Z9Lghe4VYk4', title: '', notes: ''
    },
    {
      link: 'https://www.youtube.com/watch?v=c-e4B-9PmsE', title: '', notes: ''
    },
    {
      link: 'https://www.youtube.com/watch?v=9FwtGDVcSwQ', title: '', notes: ''
    },
    {
      link: 'https://www.youtube.com/watch?v=PKum65iMgA8', title: '', notes: ''
    }
  ];

  public processPrevClip() {

    this.index--;

    if (this.index < 0) {
      this.index = this.videoLinkCollection.length - 1;
    }

    this.resetTempData();
  }

  public processNextClip() {

    this.index++;

    if (this.index >= this.videoLinkCollection.length) {
      this.index = 0;
    }

    this.resetTempData();
  }

  public processSaveVideoData() {

      this.videoLinkCollection[this.index].title = this.modelTitle;
      this.videoLinkCollection[this.index].notes = this.modelNote;
      this.resetTempData();
  }

  public processVideoRecord(videoElement, index) {
    this.index = index;
  }

  private resetTempData() {

    this.modelTitle = '';
    this.modelNote  = '';
  }
}
