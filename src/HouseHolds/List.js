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
      <header className='list-header'>
        <div>이름</div>
        <div>주소</div>
        <div>연세</div>
        <div>연락처</div>
        <div>보호자이름</div>
        <div>보호자 연락처</div>
      </header>
      {dummyLists.map((household) => (
        <div>
          <div>{household.name}</div>
          <div>{household.address}</div>
          <div>{household.age}</div>
          <div>{household.phone}</div>
          <div>{household.supporter}</div>
          <div>{household.supporterPhone}</div>
        </div>
      ))}
    </div>
  );
};

export default List;
