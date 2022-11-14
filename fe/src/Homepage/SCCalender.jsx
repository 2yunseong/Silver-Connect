import Calendar from '@toast-ui/react-calendar';
import DatePicker from './DatePicker';
import '@toast-ui/calendar/dist/toastui-calendar.min.css';

function SCCalender() {
  return (
    <div className="mx-8 w-3/5">
      <div className="flex justify-between items-center">
        <DatePicker />
        <img className="h-full" src="./images/alertBar.png" alt="alertBar" />
      </div>
      <div id="calender">
        <Calendar usageStatistics={false} view={'month'} />
      </div>
    </div>
  );
}

export default SCCalender;
