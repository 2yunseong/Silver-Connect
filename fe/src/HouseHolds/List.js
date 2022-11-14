import Select from './Select';

const dummyLists = [
  {
    name: '장광팔',
    address: '광주광역시 북구 호동로 73번길 71',
    age: '80',
    phone: '010-0000-0000',
    supporter: '김선희',
    supporterPhone: '010-1111-1111',
  },
  {
    name: '최득춘',
    address: '광주광역시 북구 호동로 77번길 71',
    age: '93',
    phone: '010-0000-0000',
    supporter: '김선희',
    supporterPhone: '010-1111-1111',
  },
  {
    name: '최길남',
    address: '광주광역시 북구 호동로 70번길 71',
    age: '72',
    phone: '010-0000-0000',
    supporter: '박미정',
    supporterPhone: '010-1111-1111',
  },
  {
    name: '이남희',
    address: '광주광역시 북구 문화로 71',
    age: '78',
    phone: '010-0000-0000',
    supporter: '김영희',
    supporterPhone: '010-1111-1111',
  },
];

const List = () => {
  return (
    <div className='household-list'>
      <header className='list-header flex flex-row'>
        <div className='px-10'>이름</div>
        <div className='px-10'>주소</div>
        <div className='px-10'>연세</div>
        <div className='px-10'>연락처</div>
        <div className='px-10'>보호자 이름</div>
        <div className='px-10'>보호자 연락처</div>
      </header>
      {dummyLists.map((household) => (
        <div className='flex flex-row'>
          <div className='px-10'>{household.name}</div>
          <div className='px-10'>{household.address}</div>
          <div className='px-10'>{household.age}</div>
          <div className='px-10'>{household.phone}</div>
          <div className='px-10'>{household.supporter}</div>
          <div className='px-10'>{household.supporterPhone}</div>
        </div>
      ))}
    </div>
  );
};

export default List;
