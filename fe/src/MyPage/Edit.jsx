const Edit = () => {
  return (
    <>
      <div className='name-element flex'>
        <div className='w-1/3'>이름</div>
        <input />
      </div>
      <div className='phone-element flex'>
        <div className='w-1/3'>연락처</div>
        <input />
      </div>
      <div className='flex'>
        <div className='w-1/3'>변경할 비밀번호</div>
        <input />
      </div>
      <div className='flex'>
        <div className='w-1/3'>변경할 비밀번호 확인</div>
        <input />
      </div>
    </>
  );
};

export default Edit;
