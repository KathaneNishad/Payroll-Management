import { NgModule } from '@angular/core';
//import { NgTemplateOutlet } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { MatSelectModule } from '@angular/material/select'; 
import { FormControl } from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { SignupComponent } from './pages/signup/signup.component'; 
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field'; 
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component'; 
import { MatToolbarModule } from '@angular/material/toolbar'; 
import { MatIconModule } from '@angular/material/icon'; 
import { MatCardModule } from '@angular/material/card'; 
import { authInterceptorProviders } from './services/auth.interceptor';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserDashboardComponent } from './pages/employee/user-dashboard/user-dashboard.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { MatListModule }  from '@angular/material/list';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { EmployeesComponent } from './pages/admin/employees/employees.component';
import { WelcomeEmpComponent } from './pages/employee/welcome-emp/welcome-emp.component';
import { SidebarEmpComponent } from './pages/employee/sidebar-emp/sidebar-emp.component';
import { LeaveComponent } from './pages/employee/leave/leave.component';
import { RequestleaveComponent } from './pages/employee/requestleave/requestleave.component';
import { LeavestatusComponent } from './pages/employee/leavestatus/leavestatus.component'; 
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CheckLeavesComponent } from './pages/admin/check-leaves/check-leaves.component';
import { LeaveChartComponent } from './pages/employee/leave-chart/leave-chart.component';
import { LeaveChartAdminComponent } from './pages/admin/leave-chart-admin/leave-chart-admin.component';
import { LeaveAdminComponent } from './pages/admin/leave-admin/leave-admin.component';
import { PaymasterComponent } from './pages/admin/paymaster/paymaster.component';
import { EmppayrollComponent } from './pages/employee/emppayroll/emppayroll.component';
//import { EditleaveComponent } from './pages/admin/editleave/editleave.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { PayslipComponent } from './pages/employee/payslip/payslip.component'; 
import { NgxPrintModule } from 'ngx-print';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DashboardComponent,
    UserDashboardComponent,
    ProfileComponent,
    SidebarComponent,
    WelcomeComponent,
    EmployeesComponent,
    WelcomeEmpComponent,
    SidebarEmpComponent,
    LeaveComponent,
    RequestleaveComponent,
    LeavestatusComponent,
    CheckLeavesComponent,
    LeaveChartComponent,
    LeaveChartAdminComponent,
    LeaveAdminComponent,
    PaymasterComponent,
    EmppayrollComponent,
    PayslipComponent,
  ],
  imports: [
    
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatListModule,
    MatDatepickerModule,
    MatSelectModule,
    MatGridListModule,
    NgxPrintModule
    
    //NgTemplateOutlet,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
