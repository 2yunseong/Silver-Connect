const Add = ({ isAddClick, setIsAddClick }) => {
  const onClick = () => {
    alert('추가 완료.');
    setIsAddClick(() => !isAddClick);
  };
  return (
    <div className='px-10 py-5 absolute bg-white rounded-lg border shadow-lg'>
      <div className='flex py-5'>
        <div>이름</div>
        <input placeholder='이름' />
      </div>
      <div className='flex py-2'>
        <div>주소</div>
        <input placeholder='주소' />
      </div>
      <div className='flex py-2'>
        <div>연세</div>
        <input placeholder='연세' />
      </div>
      <hr />
      <div className='flex py-2'>
        <div>보호자</div>
        <input placeholder='보호자 이름' />
      </div>
      <div className='flex py-2'>
        <div>연락처</div>
        <input placeholder='보호자 연락처' />
      </div>
      <button
        onClick={onClick}
        className='px-2 bg-blue-600 rounded-lg text-white'
      >
        추가
      </button>
    </div>
  );
};

export default Add;
