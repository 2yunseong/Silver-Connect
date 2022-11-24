const SignUp = () => {
  return (
    <div className='mx-auto my-0 w-4/5'>
      <h1 className='font-bold text-2xl'>회원가입</h1>
      <div className='flex flex-col w-100'>
        <div className='flex justify-between text-justify'>
          <span className='w-1/3'>이름:</span>
          <input className='w-2/3' type='text' placeholder='이름' />
        </div>
        <div className='flex justify-between text-justify'>
          <span className='w-1/3'>이메일:</span>
          <input
            className='w-2/3'
            type='text'
            placeholder='example@jnu.ac.kr'
          />
        </div>
        <div className='flex justify-between text-justify'>
          <span className='w-1/3'>아이디:</span>
          <input className='w-2/3' type='text' placeholder='ID' />
        </div>
        <div className='flex justify-between text-justify'>
          <span className='w-1/3'>비밀번호:</span>
          <input className='w-2/3' type='password' placeholder='비밀번호' />
        </div>
        <div className='flex justify-between text-justify'>
          <span className='w-1/3'>비밀번호 확인:</span>
          <input className='w-2/3' type='password' placeholder='비밀번호' />
        </div>
        <button>회원가입</button>
      </div>
    </div>
  );
};

export default SignUp;
