function CheckFirstName(form)
{
  if (form1.emp_f_name.value.length == 0)
  {
     alert("please enter first name");
     form1.emp_f_name.focus();
     return;
  }
  return this;
}