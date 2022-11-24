import profile from './profile.png';

const Edit = () => {
  return (
    <div className='text-2xl font-semibold text-left'>
      <img className='rounded-full w-40 p-3 m-3' src={profile} alt='profile' />
      <div className='name-element flex py-5'>
        <div className='w-1/3'>이름</div>
        <input className='font-normal w-2/3' placeholder='ex)이윤성' />
      </div>
      <div className='phone-element flex py-5'>
        <div className='w-1/3 '>연락처</div>
        <input className='font-normal w-2/3' placeholder='(010-1234-1234)' />
      </div>
      <div className='flex py-5'>
        <div className='w-1/3'>변경할 비밀번호</div>
        <input
          className='font-normal w-2/3'
          placeholder='변경할 비밀번호 입력..'
          type='password'
        />
      </div>
      <div className='flex py-5'>
        <div className='w-1/3'>변경할 비밀번호 확인</div>
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
