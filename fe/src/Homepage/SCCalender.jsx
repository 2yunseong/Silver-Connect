import Calendar from '@toast-ui/react-calendar';
import DatePicker from './DatePicker';
import '@toast-ui/calendar/dist/toastui-calendar.min.css';

function SCCalender() {
  const initialEvents = [
    {
      id: '1',
      calendarId: 'cal1',
      title: '박봉선',
      start: new Date().toDateString(),
      end: new Date().toDateString(),
    },
    {
      id: '2',
      calendarId: 'cal1',
      title: '최득춘',
      start: new Date().toDateString(),
      end: new Date().toDateString(),
    },
  ];

  return (
    <div className="mx-8 w-3/5">
      <div className="flex justify-between items-center">
        <DatePicker />
        <img className="h-full" src="./images/alertBar.png" alt="alertBar" />
      </div>
      <div id="calender">
        <Calendar
          usageStatistics={false}
          view={'month'}
          events={initialEvents}
        />
      </div>
    </div>
  );
}

export default SCCalender;
