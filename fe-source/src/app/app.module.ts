import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';

import {TimeAgoPipe} from 'time-ago-pipe';

import {AppComponent} from './app.component';
import {CommitListComponent} from './commit-list/commit-list.component';
import {TableElementsCountComponent} from './table-elements-count/table-elements-count.component';
import {TablePaginationComponent} from './table-pagination/table-pagination.component';
import {TableSortComponent} from './table-sort/table-sort.component';
import {CommitService} from './commit.service';
import { GroupByPipe } from './group-by.pipe';

const appRoutes: Routes = [
    {path: '', component: CommitListComponent}
];

@NgModule({
    declarations: [
        AppComponent,
        CommitListComponent,
        TableElementsCountComponent,
        TablePaginationComponent,
        TableSortComponent,
        TimeAgoPipe,
        GroupByPipe
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(appRoutes)
    ],
    providers: [CommitService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
