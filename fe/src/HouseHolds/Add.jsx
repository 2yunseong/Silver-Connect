import useInput from '../Hooks/useInput';

const Add = ({ isAddClick, setIsAddClick }) => {
  const name = useInput();
  const address = useInput();
  const age = useInput();
  const residentPhone = useInput();
  const guardianName = useInput();
  const guardianPhone = useInput();

  const onClick = () => {
    fetch('http://133.186.219.125:8080/api/household', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        address: address.value,
        residentName: name.value,
        residentAge: age.value,
        residentPhoneNumber: residentPhone.value,
      }),
    }).then((response) => {
      fetch('http://133.186.219.125:8080/api/guardian', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          name: guardianName.value,
          age: age.value,
          phoneNumber: guardianPhone.value,
          residentPhoneNumber: residentPhone.value,
        }),
      }).then(() => {
        console.log(response.json());
        alert('추가 완료.');
        setIsAddClick(() => !isAddClick);
      });
    });
  };

  return (
    <div className='px-10 py-5 absolute bg-white rounded-lg border shadow-lg w-3/5'>
      <div className='flex py-5'>
        <div>이름</div>
        <input placeholder='이름' onChange={name.onChange} />
      </div>
      <div className='flex py-2'>
        <div>주소</div>
        <input placeholder='주소' onChange={address.onChange} />
      </div>
      <div className='flex py-2'>
        <div>연세</div>
        <input placeholder='연세' onChange={age.onChange} />
      </div>
      <div className='flex py-2'>
        <div>연락처</div>
        <input placeholder='연락처' onChange={residentPhone.onChange} />
      </div>
      <hr />
      <div className='flex py-2'>
        <div>보호자</div>
        <input placeholder='보호자 이름' onChange={guardianName.onChange} />
      </div>
      <div className='flex py-2'>
        <div>연락처</div>
        <input placeholder='보호자 연락처' onChange={guardianPhone.onChange} />
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
