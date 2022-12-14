import profile from './profile.png';

const Edit = ({ name, phone, changeName, changePhone, changePassword }) => {
  return (
    <div className='text-normal font-semibold text-left w-4/5'>
      <img className='rounded-full w-40 my-5' src={profile} alt='profile' />
      <div className='name-element flex py-5'>
        <div className='w-1/3'>이름</div>
        <input
          className='font-normal w-2/3'
          placeholder='ex)이윤성'
          value={name}
          onChange={changeName}
        />
      </div>
      <div className='phone-element flex py-5'>
        <div className='w-1/3 '>연락처</div>
        <input
          className='font-normal w-2/3'
          placeholder='(010-1234-1234)'
          value={phone}
          onChange={changePhone}
        />
      </div>
      <div className='flex py-5'>
        <div className='w-1/3'>새 비밀번호:</div>
        <input
          className='font-normal w-2/3'
          placeholder='변경할 비밀번호 입력..'
          type='password'
          onChange={changePassword}
        />
      </div>
      <div className='flex py-5'>
        <div className='w-1/3'>비밀번호 확인:</div>
        <input
          className='font-normal w-2/3'
          placeholder='변경할 비밀번호 확인'
          type='password'
        />
      </div>
    </div>
  );
};

export default Edit;
