import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  public index = 0;

  public tempTitle;
  public tempNote;

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

  public processInputVideoNote(input) {
    // this.tempNote = input.target.value;
    this.tempNote = input.target;
  }

  public processInputVideoTitle(input) {

    // this.tempTitle = input.target.value;
    this.tempTitle = input.target;
  }

  public processSaveVideoData() {

      this.videoLinkCollection[this.index].title = this.tempTitle.value;
      this.videoLinkCollection[this.index].notes = this.tempNote.value;
      this.resetTempData();
  }

  private resetTempData() {

    // this.tempTitle  = '';
    // this.tempNote   = '';

    this.tempTitle.value  = '';
    this.tempNote.value   = '';
  }
}
