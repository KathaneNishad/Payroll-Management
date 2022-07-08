import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckLeavesComponent } from './pages/admin/check-leaves/check-leaves.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
//import { EditleaveComponent } from './pages/admin/editleave/editleave.component';
import { EmployeesComponent } from './pages/admin/employees/employees.component';
import { LeaveAdminComponent } from './pages/admin/leave-admin/leave-admin.component';
import { LeaveChartAdminComponent } from './pages/admin/leave-chart-admin/leave-chart-admin.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { EditProfileComponent } from './pages/edit-profile/edit-profile.component';
import { LeaveChartComponent } from './pages/employee/leave-chart/leave-chart.component';
import { LeaveComponent } from './pages/employee/leave/leave.component';
import { LeavestatusComponent } from './pages/employee/leavestatus/leavestatus.component';
import { RequestleaveComponent } from './pages/employee/requestleave/requestleave.component';
import { UserDashboardComponent } from './pages/employee/user-dashboard/user-dashboard.component';
import { WelcomeEmpComponent } from './pages/employee/welcome-emp/welcome-emp.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AdminGuard } from './services/admin.guard';
import { EmployeeGuard } from './services/employee.guard';

const routes: Routes = [
  {path:'signup',component: SignupComponent,pathMatch:'full'},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path:'admin',component:DashboardComponent,canActivate:[AdminGuard],
    children:[
      {
        path:'',component:WelcomeComponent,
      },
      {
        path:'profile',component:ProfileComponent,
      },
      {
        path:'edit',component:EditProfileComponent,
      },
      {
        path:'employees',component:EmployeesComponent,
      },
      {
        path:'viewallleave',component:CheckLeavesComponent,
      },
     // {
      //  path:'update-leave',component:EditleaveComponent,
     // }
      {
        path: 'leave-admin',component:LeaveAdminComponent,
      },
      {
        path:'leave-chart-admin',component:LeaveChartAdminComponent,
      }

    ]
  },
  {path:'user',component:UserDashboardComponent,canActivate:[EmployeeGuard],
  children:[
    {
      path:'',component:WelcomeEmpComponent,
    },
    {
      path:'edit',component:EditProfileComponent,
    },
    {
      path:'profile',component:ProfileComponent,
    },
    {
      path:'leave',component:LeaveComponent,
    },
    {
      path:'request-leave',component:RequestleaveComponent,
    },
    {
      path:'leave-status',component:LeavestatusComponent,
    },
    {
      path:'leave-chart',component:LeaveChartComponent,
    }
  ]
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
